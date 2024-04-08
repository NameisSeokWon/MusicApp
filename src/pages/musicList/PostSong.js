import { useState } from "react";
import "./PostSong.css";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import {useNavigate} from "react-router-dom";

const PostSong = () => {
    const [formData, setFormData] = useState({
        singer: "",
        title: ""
    });

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        setFormData({
            ...formData,
            [name]: value
        });
    };

    const navigate = useNavigate();

    const handleSubmit = async(e) =>{
        e.preventDefault();

        console.log(formData);

        try{
            const response = await fetch("http://localhost:8080/api/musicList",{
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(formData)
            });

            const data =await response.json();
            console.log("A music is requested : ", data);
            navigate("/")

        } catch(error){
            console.log("Error creating musiclist", error.message);
        }
    }

    return (
        <>
            <div className="center-form">
                <h1>Request your favorite song!!</h1>
                <Form onSubmit={handleSubmit}>
                    <Form.Group controlId="formBasicName">
                        <Form.Control
                            type="text"
                            name="singer"
                            placeholder="歌手のお名前を入力してください"
                            defaultValue={formData.singer}
                            onChange={handleInputChange}
                        />
                    </Form.Group>
                    <Form.Group controlId="formBasicName">
                        <Form.Control
                            type="title"
                            name="title"
                            placeholder="タイトルを入力してください"
                            defaultValue={formData.title}
                            onChange={handleInputChange}
                        />
                    </Form.Group>
                    <Button variant="primary" type="submit" className="w-100">
                        検索
                    </Button>
                </Form>
                <div className="youtube-container">
                    <h2>検索結果</h2>
                    <div className="youtube-video">
                        <iframe
                            width="859"
                            height="483"
                            src="https://www.youtube.com/embed/P9tKTxbgdkk"
                            title="TXT (투모로우바이투게더) 'Sugar Rush Ride' Official MV"
                            frameBorder="0"
                            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                            referrerPolicy="strict-origin-when-cross-origin"
                            allowFullScreen
                        ></iframe>
                    </div>
                    <Button variant="primary" className="btn-request">
                        申請
                    </Button>
                </div>
            </div>
        </>
    );
};

export default PostSong;

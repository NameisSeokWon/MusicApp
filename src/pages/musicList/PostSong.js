import { useState } from "react";
import "./PostSong.css";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";

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

    return (
        <>
            <div className="center-form">
                <h1>Request your favorite song!!</h1>
                <Form>
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
                        申請
                    </Button>
                </Form>
            </div>
        </>
    );
};

export default PostSong;

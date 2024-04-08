import React, { useState, useEffect } from "react";
import "./Dashboard.css";
import Container from "react-bootstrap/Container";
import { Col, Row } from "react-bootstrap";
import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";

const Dashboard = () => {
    const [musicLists, setMusicLists] = useState([]);

    useEffect(() => {
        const fetchMusicLists = async () => {
            try {
                const response = await fetch("http://localhost:8080/api/musicLists");
                const data = await response.json();

                setMusicLists(data);
            } catch (error) {
                console.error("Error fetching musicLists:", error.message);
            }
        };
        fetchMusicLists();
    }, []);

    const [currentTime, setCurrentTime] = useState(new Date());

    useEffect(() => {
        const intervalId = setInterval(() => {
            setCurrentTime(new Date());
        }, 1000);
        return () => clearInterval(intervalId);
    }, []);

    return (
        <Container className="mt-5">
            <Row>
                <Col>
                    <h1 className="text-center">MusicLists</h1>
                    <Table striped bordered hover responsive>
                        <thead>
                        <tr>
                            <th>順番</th>
                            <th>アーティスト</th>
                            <th>タイトル</th>
                            <th>申請時間</th>
                            <th>操作</th> {/* 새로운 헤더 셀 추가 */}
                        </tr>
                        </thead>
                        <tbody>
                        {musicLists.map((musicList, index) => (
                            <tr key={musicList.id}>
                                <td>{index + 1}</td> {/* index 값은 0부터 시작하므로 1을 더해줌 */}
                                <td>{musicList.singer}</td>
                                <td>{musicList.title}</td>
                                <td>{musicList.requesttime}</td>
                                <td>
                                    <Button variant="outline-secondary">Update</Button>{" "}
                                    <Button variant="outline-danger">Delete</Button>
                                </td>
                            </tr>
                        ))}
                        </tbody>
                    </Table>
                </Col>
            </Row>
        </Container>
    );
};

export default Dashboard;

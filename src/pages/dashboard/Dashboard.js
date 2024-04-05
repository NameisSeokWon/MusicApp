import React, { useState, useEffect } from "react";
import "./Dashboard.css";

const Dashboard = () => {
    const data = [
        { no: 1, singer: "Ariana Grande", title: "pov", time: "2024-04-06 10:00" },
        { no: 2, singer: "IVE", title: "I AM(I AM)", time: "2024-04-06 11:00" },
        // 나머지 데이터도 추가...
    ];

    const [currentTime, setCurrentTime] = useState(new Date());

    useEffect(() => {
        const intervalId = setInterval(() => {
            setCurrentTime(new Date());
        }, 1000);
        return () => clearInterval(intervalId);
    }, []);

    return (
        <div className="dashboard">
            <div className="top-right">
                <div className="current-time">
                    <span style={{fontSize: '24px', fontWeight: 'bold'}}>
                        {currentTime.toLocaleTimeString()}
                    </span>
                </div>
                <img src="/image/images.png" alt="Restaurant Image"/>
            </div>
            <h1>プレイリスト</h1>
            <div className="list-container">
                <table>
                    <thead>
                    <tr>
                        <th>順番</th>
                        <th>アーティスト</th>
                        <th>タイトル</th>
                        <th>申請時間</th>
                    </tr>
                    </thead>
                    <tbody>
                    {data.map((item, index) => (
                        <tr key={index}>
                            <td>{item.no}</td>
                            <td>{item.singer}</td>
                            <td>{item.title}</td>
                            <td>{item.time}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
            <div className="video-container">
                <iframe
                    width="935"
                    height="526"
                    src="https://www.youtube.com/embed/lf_wVfwpfp8"
                    title="Ariana Grande - Focus (Official Video)"
                    frameborder="0"
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                    referrerpolicy="strict-origin-when-cross-origin"
                    allowfullscreen
                ></iframe>
            </div>
        </div>
    );
};

export default Dashboard;

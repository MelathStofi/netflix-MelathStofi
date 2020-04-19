import React, { useState, useEffect } from 'react';
import axios from 'axios';
import ListElement from './ListElement';

export default function VideoList() {

    const [videos, setVideos] = useState([]);

    useEffect(() => {
        axios.get(`http://localhost:8762/videoservice/videos`, { withCredentials: true })
        .then(resp => setVideos(resp.data));
    }, [setVideos]);

    return (
        <div>
            {videos.map((video) => (
                <ListElement key={video.id} video={video} />
            ))}            
        </div>
    )
}

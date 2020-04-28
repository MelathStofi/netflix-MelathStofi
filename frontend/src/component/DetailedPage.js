import React, { useState, useEffect } from 'react'
import axios from 'axios';
import AddRecomBut from './AddRecomBut';

const DetailedPage = (props) => {

    let videoId = props.match.params.id;
    const [video, setVideo] = useState({});

    useEffect(() => {
        axios.get(`http://localhost:8762/videoservice/videos/${videoId}`, { withCredentials: true })
        .then(resp => setVideo(resp.data));
    }, [setVideo, videoId]);

    return (
        <div>
            <h2>{video.name}</h2>
            <iframe width="420" height="315" src={video.url} title={video.name} ></iframe>
            <AddRecomBut video={[video, setVideo]} />
            {video.recommendations !== undefined && video.recommendations.map((rec) => (
                <div key={rec.id} >Rating: {rec.rating}
                    <ul>{rec.comment}</ul></div>
            ))}
        </div>
    )
}

export default DetailedPage;

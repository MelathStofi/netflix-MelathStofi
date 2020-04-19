import React, { useState } from 'react';
import { useHistory } from 'react-router-dom';
import axios from 'axios';

const AddRecomBut = (props) => {
    const [video, setVideo] = props.video;
    const history = useHistory();
    const [isRecom, setIsRecom] = useState(false);
    const [comment, setComment] = useState("");
    const [rating, setRating] = useState("");

    const addRecommendation = () => {
        if (!isRecom) {
            setIsRecom(true);
        }
        else if (isRecom && !(rating === "")) {
            const recommendation = {
                "id": "",
                "rating": rating,
                "comment": comment
            }
            console.log(recommendation);
            axios({
                method: "post",
                url: `http://localhost:8762/videoservice/videos/recommendation/${video.id}`,
                data: recommendation, 
                withCredentials: true
            })
            .then(resp => {
                console.log(resp.data);
                if (resp.status === 200) {
                    history.push(`/video/${video.id}`);
                    let newVideo = video;
                    const recomList = [...video.recommendations, recommendation];
                    newVideo.recommendations = recomList;
                    setVideo(newVideo);
                }
            });
            setIsRecom(false);
        }
    };

    return (
        <div>
            { isRecom ?
                <React.Fragment>
                    <select id="rating" onChange={e => setRating(e.target.value)} >
                        <option >Not Rated</option>
                        <option value="1">Really Bad</option>
                        <option value="2">Bad</option>
                        <option value="3">OK</option>
                        <option value="4">Good</option>
                        <option value="5">Really Good</option>
                    </select>
                    <input 
                        type="text" 
                        name="new-comment" 
                        placeholder="Add comment..."
                        onChange={e => setComment(e.target.value)} />
                    <button onClick={() => addRecommendation()} >Add</button>
                </React.Fragment>
                :
                <button onClick={() => addRecommendation()} >Add recommendation</button>
            }
        </div>
    )
}

export default AddRecomBut;

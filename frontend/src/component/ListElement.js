import React from 'react';
import { Link } from 'react-router-dom';

const ListElement = (props) => {

    const video = props.video;

    return (
        <div>
            <Link to={{ pathname: `/video/${video.id}`, query: video }}>
                {props.video.id} {props.video.name}
            </Link>
        </div>
    )
}

export default ListElement;

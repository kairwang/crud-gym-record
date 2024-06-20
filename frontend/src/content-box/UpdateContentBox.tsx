import React from 'react';

import './ContentBox.css';

import {GymRecord} from '../entities/GymRecord'

interface ContentBoxProps {
    onSubmit: (record: GymRecord) => void;
    content: GymRecord;
}

const UpdateContentBox: React.FC<ContentBoxProps> = ({ onSubmit, content }) => {
    const [record, setRecord] = React.useState<GymRecord>(content);

    const handleSubmit = () => {
        onSubmit(record);
    };

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setRecord({...record, weight: parseInt(e.target.value)});
    };

    return (
        <div className="content-box">
            <input
                type="text"
                value={record.exercise}
                onChange={(e) => setRecord({...record, exercise: e.target.value})}
                placeholder="Exercise Name"
             />
            <input
                type="number"
                value={record.weight}
                onChange={handleChange}
                placeholder="Weight in lb"
             />
            <button onClick={handleSubmit}>Update</button>
        </div>
    );
}

export default UpdateContentBox;
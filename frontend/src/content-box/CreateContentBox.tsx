import React from 'react';
import './ContentBox.css';

import {GymRecord} from '../entities/GymRecord'

interface ContentBoxProps {
    onSubmit: (exercise: string, weight: number) => void;
}

const CreateContentBox: React.FC<ContentBoxProps> = ({ onSubmit }) => {
    const [exercise, setExercise] = React.useState("");
    const [weight, setWeight] = React.useState<number>();

    const handleSubmit = () => {
        onSubmit(exercise, weight || 0);
        setExercise("");
        setWeight(0);
    };

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setWeight(parseInt(e.target.value));
    };

    return (
        <div className="content-box">
            <input
                type="text"
                value={exercise}
                onChange={(e) => setExercise(e.target.value)}
                placeholder="Exercise Name"
             />
            <input
                type="number"
                value={weight}
                onChange={handleChange}
                //onChange={(e) => setExercise(parseInt(e.target.value)} not working
                placeholder="Weight in lb"
             />
            <button onClick={handleSubmit}>Create</button>
        </div>
    );
}

export default CreateContentBox;
import React, { useEffect, useState } from 'react'
import styles from "../styles/stylequizcard.module.css"

function StyleQuizCard({ key, style, img }) {
    const [opacity, setOpacity] = useState(1);
    const [selected, setSelected] = useState(false);
    const id = key;

    function handleClickSubmit() {
        if (opacity == 1) {
            setOpacity(0.5); setSelected(true);
        }
        else {
            setOpacity(1); setSelected(false);
        }
    }

    return (
        <div className="col">
            <div className="p-0">
                <button
                    className={styles.btnCard}
                    onClick={() => (
                        handleClickSubmit()
                    )}
                >
                    <div
                        className={`card ${styles.cardHover}`}
                        style={{ width: 27 + 'rem', height: 17 + 'rem' }}
                    >
                        <img src={img} className="card-img-top" alt={style} style={{ opacity: opacity }} />
                    </div>
                </button>
            </div>
        </div>
    )
}

export default StyleQuizCard;
/* eslint-disable react/no-unescaped-entities */
/* eslint-disable @next/next/no-img-element */
import React, { Component } from "react";
import styles from "./cardSlider.module.css";


export default function CardSlider() {
  return (
    <div className={styles.cardWrapper}>
     <div className={styles.cardSlider}>
      <div className={`card ${styles.cardCustom} `} style={{ width: 65 + 'rem' , height: 30 + 'em'}}>
        <img src='/slider1.png' alt="img1" className=" mt-0 card-img-top" />
        <div className="card-body">
          <h5 className="card-title d-flex justify-content-center">Card title</h5>
          <p className="card-text d-flex justify-content-center mt-3">
            Some quick example text to build on the card title and make up the
            bulk of the card's content.
          </p>
        </div>
      </div>
      <div className={`card ${styles.cardCustom}`} style={{ width: 65 + 'rem' , height: 30 + 'em'}}>
        <img src='/slider2.png' alt="img2" className=" mt-0 card-img-top" />
        <div className="card-body">
          <h5 className="card-title d-flex justify-content-center">Card title</h5>
          <p className="card-text d-flex justify-content-center mt-3">
            Some quick example text to build on the card title and make up the
            bulk of the card's content.
          </p>
        </div>
      </div>
      <div className={`card ${styles.cardCustom}`} style={{ width: 65 + 'rem' , height: 30 + 'em'}}>
        <img src='/slider3.png' alt="img3" className=" mt-0 card-img-top" />
        <div className="card-body">
          <h5 className="card-title d-flex justify-content-center">Card title</h5>
          <p className="card-text d-flex justify-content-center mt-3">
            Some quick example text to build on the card title and make up the
            bulk of the card's content.
          </p>
        </div>
      </div>
      </div>   
      <button type="button" className={`btn btn-outline mx-2 ${styles.btnCustomOutlinePrimary}`}>Browse all ideas</button>
    </div>
  );
}

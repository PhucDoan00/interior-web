import styles from "./designstyle.module.css";
import React from 'react';
import Image from "next/image"

export default function Designstyle() {
  return (
    <div className="container">
  <div className="row justify-content-center" style={{
    margin:'80px 0'
  }}>
    <div className="col-4">
         <Image src={'/15.png'} width='539' height='600'  />
    </div>
    <div className="col-4">
      <div>
       <p className={styles.a}> What’s Your Design Style </p>
       <p className={styles.b}> Amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi. </p>
        <div className="row">
            <div className="col-4">
     <button type="button" className={`btn btn-outline mx-2 ${styles.btnCustomOutlinePrimary}`}>
        Take Style Quiz
      </button>
            </div>
        </div>
    </div>
    </div>
  </div>
 </div>
  );
}

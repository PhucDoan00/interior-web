import styles from "./designstyle.module.css";
import React from 'react';
import Image from "next/image"

export default function Designstyle() {
  return (
    <div class="container-fluid"> 
    <div class="row">
    <div class="col-6">
        <div class="row">
            <div className="col-2"></div>
            <div class="col-4">
                    <Image src={'/15.png'} width={529} height={652} />          
            </div>
        </div>
    </div>
    <div class="col-6">
       <p className={styles.a}> What’s Your Design Style </p>
       <p className={styles.b}> Amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi. </p>
        <div class="row">
            <div className="col-2"></div>
            <div class="col-4">
     <button type="button" className={`btn btn-outline mx-2 ${styles.btnCustomOutlinePrimary}`}>
        Take Style Quiz
      </button>
            </div>
        </div>
    </div>
  </div>
</div>
  );
}

import styles from "./loveit.module.css";
import React from 'react';
import Image from "next/image"

export default function Loveit() {
  return (
      <div style={{backgroundColor: '#faf4ed'}}>
    <div class="container" >
        <div class="row">
                 <div class="col-4">
            </div>
            <div class="col-4"> 
                <div className={styles.c}>
                    <p>People love this!</p>
                </div>
            </div>
            <div class="col-4">
               
            </div>
        </div>
    <div class="row">
            <div class="col-3">
                <div className={styles.b}>
                    <p>“Lorem ipsum dolor sit amet, consectetuer adipiscing elit. “</p>
                        <p>Arlene McCoy</p>
                </div>
            </div>
            <div class="col-3"> 
                <div className={styles.b}>
                    <p>“Lorem ipsum dolor sit amet, consectetuer adipiscing elit. “</p>
                        <p>Darlene Robertson</p>
                </div>
            </div>
            <div class="col-3">
                <div className={styles.b}>
                    <p>“Lorem ipsum dolor sit amet, consectetuer adipiscing elit. “</p>
                        <p>Bessie Cooper</p>
                </div> 
            </div>
            <div class="col-3">
                <div className={styles.b}>
                
                        <p>“Lorem ipsum dolor sit amet, consectetuer adipiscing elit. “</p>
                        <p>Wade Warren</p>
                    
                </div> 
            </div>
    </div>
  </div>
  </div>
  );
}

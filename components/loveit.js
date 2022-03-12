import styles from "./loveit.module.css";
import React from 'react';
import Image from "next/image"

export default function Loveit() {
  return (
 <div style={{backgroundColor: '#faf4ed'}}>
     
    <div className="container" >
        <div className="row">
                 <div className="col-4">
            </div>
            <div className="col-4"> 
                <div className={styles.c}>
                    <p>People love this!</p>
                </div>
            </div>
            <div className="col-4">
               
            </div>
        </div>
    <div className="row">
            <div className="col-3">
                <div className={styles.b}>
                    <p>“Lorem ipsum dolor sit amet, consectetuer adipiscing elit. “</p>
                        
                        <p className={styles.d}>Arlene McCoy</p>
                </div>
            </div>
            <div className="col-3"> 
                <div className={styles.b}>
                    <p>“Lorem ipsum dolor sit amet, consectetuer adipiscing elit. “</p>
                        <p className={styles.d}>Darlene Robertson</p>
                </div>
            </div>
            <div className="col-3">
                <div className={styles.b}>
                    <p>“Lorem ipsum dolor sit amet, consectetuer adipiscing elit. “</p>
                        <p className={styles.d}>Bessie Cooper</p>
                </div> 
            </div>
            <div className="col-3">
                <div className={styles.b}>
                
                        <p>“Lorem ipsum dolor sit amet, consectetuer adipiscing elit. “</p>
                        <p className={styles.d}>Wade Warren</p>
                    
                </div> 
            </div>
    </div>
</div>
  </div>
  );
}

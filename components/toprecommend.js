import styles from "./toprecommend.module.css";
import React from 'react';
import Image from "next/image"

export default function Toprecommend() {
  return (
    <div className="container-fluid">
  
        <div className="row">
         <div className="col-1"> 
            </div>
            <div className="col-6"> 
                <p className={styles.a}> This is title </p>
            </div>
            <div className="col-3">
               <p className={styles.b}> Top Recommend </p>
            </div>
        </div>
    <div className="row">
    <div className="col-6">
        <div className="row">
            <div className="col-2"></div>
           
            <div className="col-4">
                <div>
                    <Image src={'/6.png'} width={208.62} height={230.47} />
                </div>

                <div>
                    <Image src={'/8.png'} width={208.62} height={267.47} />     
                </div>
                <div className="col-2"></div>
            </div>
            <div className="col-4">
                
                <div>
               <Image src={'/7.png'} width={208.62} height={315.96} />     
                </div>
                <div>
                <Image src={'/9.png'} width={208.62} height={182.92} />
                </div>
                
            </div>
        </div>
    </div>
    <div className="col-6">
       
        <div className="row">
            <div className="col-2"></div>
            <div className="col-4">
                <div>
                    <div className="row">
                        <div className="col-7">
                            <Image src={'/10.png'} width={134} height={134} />
                        </div>
                        <div className="col-5">
                            <div className={styles.e}>
                                    <div className={styles.f}>
                                        <p> Table </p>
                                    </div>
                                    <div className={styles.d}>
                                        <p> $1000 </p>
                                    </div>
                                </div>
                        </div>
                    </div>
                </div>
                <div>
                    <div className="row">
                        <div className="col-7">
                            <Image src={'/11.png'} width={134} height={134} />
                        </div>
                        <div className="col-5">
                            <div className={styles.e}>
                                    <div className={styles.f}>
                                        <p> Vase </p>
                                    </div>
                                    <div className={styles.d}>
                                        <p> $1000 </p>
                                    </div>
                                </div>
                        </div>
                    </div>
                </div>
                
                <div>
                    <div className="row">
                        <div className="col-7">
                            <Image src={'/12.png'} width={134} height={134} />
                        </div>
                        <div className="col-5">
                            <div className={styles.e}>
                                    <div className={styles.f}>
                                        <p> Mordern Chair </p>
                                    </div>
                                    <div className={styles.d}>
                                        <p> $2000 </p>
                                    </div>
                                </div>
                        </div>
                    </div>
                </div>
                <div>
                    <div className="row">
                        <div className="col-7">
                            <Image src={'/13.png'} width={134} height={134} />
                        </div>
                        <div className="col-5">
                            <div className={styles.e}>
                                    <div className={styles.f}>
                                        <p> Italia Chair </p>
                                    </div>
                                    <div className={styles.d}>
                                        <p> $1500 </p>
                                    </div>
                                </div>
                        </div>
                    </div>
                </div>
                <div className="col-2">
                </div>
            </div>
            <div className="col-2">
            </div>
        </div>
    </div>
  </div>
</div>
  );
}

import styles from './loveit.module.css'
import React from 'react'
import Image from 'next/image'

export default function Loveit() {
  return (
    <div className={styles.loveItWrapper}>
      <div className="container mb-5">
        <div className="row">
          <div className="col-4"></div>
          <div className="col-4">
            <div className={styles.c}>
              <p>People love this!</p>
            </div>
          </div>
          <div className="col-4"></div>
        </div>
        <div className="row">
          <div className={`col-3 ${styles.loveit_d}`}>
            <div className={styles.b}>
              <p>“All the features of this website is really helpful, this is my life savier.“</p>
              <div className="mt-4">
                <p className={styles.d}>Arlene McCoy</p>
              </div>
            </div>
          </div>
          <div className={`col-3 ${styles.loveit_d}`}>
            <div className={styles.b}>
              <p>“The way you always know when someone needs something is amazing. “</p>
              <p className={styles.d}>Darlene Robertson</p>
            </div>
          </div>
          <div className={`col-3 ${styles.loveit_d}`}>
            <div className={styles.b}>
              <p>“You should be thanked more often. Thank you.“</p>
              <div className="mt-5">
                <p className={styles.d}>Bessie Cooper</p>
              </div>
            </div>
          </div>
          <div className={`col-3 ${styles.loveit_d}`}>
            <div className={styles.b}>
              <p>“Every people would be lucky to know this ealier.“</p>
              <div className="mt-4">
                <p className={styles.d}>Wade Warren</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

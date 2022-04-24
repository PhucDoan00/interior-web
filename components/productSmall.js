/* eslint-disable jsx-a11y/alt-text */
/* eslint-disable @next/next/no-img-element */
import React from 'react'
import styles from './productSmall.module.css'
import Link from 'next/link'

const ProductSmall = ({ id, imgPath, name, price }) => {
  return (
    <div className={`col-sm-3 ${styles.divBig}`}>
      <div className={`d-flex align-items-center justify-content-center ${styles.divBorder}`}>
        <Link href={`/shop/${id}`}>
          <a className={styles.noneUnderscore}>
            <img src={imgPath} className={styles.styleImg} />
            <p className={styles.text}> {name} </p>
            <p className={styles.text}> {`$${price}`} </p>
          </a>
        </Link>
      </div>
    </div>
  )
}

export default ProductSmall

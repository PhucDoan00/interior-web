import React from 'react'
import styles from './productSmall.module.css'
import Link from 'next/link'
import Image from 'next/image'

const ProductSmall = ({ id, imgPath, name, price }) => {
  return (
    <div className={`col-sm-3 ${styles.divBig}`}>
      <div
        className={`d-flex align-items-center justify-content-center ${styles.divBorder}`}
        style={{
          height: '400px',
          padding: '10px',
        }}
      >
        <Link href={`/shop/${id}`} style={{ textDecoration: 'none' }}>
          <a>
            <img
              src={imgPath}
              style={{
                height: '200px',
                width: '200px',
                objectFit: 'cover',
                overflow: 'hidden',
                padding: '10px',
              }}
            />
            <p className={styles.text}> {name} </p>
            <p className={styles.text}> {price} </p>
          </a>
        </Link>
      </div>
    </div>
  )
}

export default ProductSmall

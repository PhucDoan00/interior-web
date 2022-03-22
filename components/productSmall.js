import React from 'react'
import styles from './productSmall.module.css'
import Link from 'next/link'
import Image from 'next/image'

const ProductSmall = ({ imgPath, name, price}) => {
    return (
        <div className={`col-sm-3 ${styles.divBig}`}>
            <div className={`d-flex align-items-center justify-content-center ${styles.divBorder}`}>
                <Link href={'/'} style={{ textDecoration: 'none' }}> 
                    <a> 
                        <Image src={imgPath} height={275} width={275} />
                        <p className={styles.text}> {name} </p>
                        <p className={styles.text}> {price} </p>
                    </a>
                </Link>
            </div>   
        </div>
    );
};

export default ProductSmall;
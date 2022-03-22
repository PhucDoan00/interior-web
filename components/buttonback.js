import React from 'react'
import styles from './buttonback.module.css'

export default function ButtonBack({handleClickButton}) {
  return (
    <div className="btnWrapper">
      <button type="button" className={`btn ${styles.btnCustom} `} onClick={() => handleClickButton(true)}>
        Back
      </button>
    </div>
  )
}

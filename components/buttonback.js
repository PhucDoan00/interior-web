import React from 'react'
import styles from './buttonback.module.css'

export default function ButtonBack() {
  return (
    <div className="btnWrapper">
      <button type="button" className={`btn ${styles.btnCustom} `}>
        Back
      </button>
    </div>
  )
}

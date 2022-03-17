import React from 'react'
import styles from './button.module.css'

export default function Button() {
  return (
    <div className="btnWrapper">
      <button type="button" className={`btn ${styles.btnCustom} `}>
        Back
      </button>
    </div>
  )
}

/* eslint-disable @next/next/link-passhref */
import Link from 'next/link'
import styles from './topbar.module.css'

export default function Topbar() {
  return (
    <nav className={styles.nav}>
      {/* <input className={styles.input} placeholder="Search..." /> */}
      <div className="container d-flex justify-content-between align-items-center ">
        <div className={`d-flex justify-content-between align-items-center ${styles.topbar}`}>
          <Link href="/">
            <h2 className={styles.title}>Sparkles</h2>
          </Link>
          <Link href="/stylequiz">
            <a>Style Quiz</a>
          </Link>
          <Link href="/rooms">
            <a>Design Ideas</a>
          </Link>
          <Link href="/shop">
            <a>Shop</a>
          </Link>
        </div>
        <div className="button">
          <Link href="/signup">
            <button
              type="button"
              className={`btn mx-2 btn-outline ${styles.btnCustomOutlinePrimary}`}
            >
              Sign up
            </button>
          </Link>
          <Link href="/login">
            <button type="button" className={`btn  ${styles.btnCustomPrimary}`}>
              Log in
            </button>
          </Link>
        </div>
      </div>
    </nav>
  )
}

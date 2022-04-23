/* eslint-disable @next/next/no-img-element */
/* eslint-disable @next/next/link-passhref */
import Link from 'next/link'
import { useRouter } from 'next/router'
import { useEffect, useState } from 'react'
import { confirmAlert } from 'react-confirm-alert'
import 'react-confirm-alert/src/react-confirm-alert.css'
import styles from './topbar.module.css'

export default function Topbar() {
  const [user, setUser] = useState()
  const [navbar, setNavBar] = useState(false)
  const router = useRouter()

  useEffect(() => {
    async function getUser() {
      const loggedInUser = localStorage.getItem('user')
      if (loggedInUser) {
        setUser(loggedInUser)
      }
    }
    getUser()
  })

  function signOut() {
    confirmAlert({
      title: 'Logging out',
      message: 'Are you sure to log out?',
      buttons: [
        {
          label: 'Yes',
          onClick: () => handleSignOut(),
        },
        {
          label: 'No',
          onClick: () => {},
        },
      ],
    })
  }

  const handleSignOut = () => {
    setUser('')
    // localStorage.setItem('user', '')
    localStorage.removeItem('user')
    router.push('/')
  }

  useEffect(() => {
    const opacityNavBar = () => {
      if (window.scrollY >= 80) {
        setNavBar(true)
      } else {
        setNavBar(false)
      }
    }
    window.addEventListener('scroll', opacityNavBar)
  }, [])

  return (
    <nav className={navbar ? styles.navactive : styles.nav}>
      <div className="container d-flex justify-content-between align-items-center ">
        <div className={`d-flex justify-content-between align-items-center ${styles.topbar}`}>
          <Link href="/">
            <img src="/logo/logo.png" alt="logo" style={{ height: 70 + 'px', width: 110 + 'px' }} />
          </Link>
          <Link href="/stylequiz">
            <a>Style Select</a>
          </Link>
          <Link href="/rooms">
            <a>Design Ideas</a>
          </Link>
          <Link href="/shop">
            <a>Shop</a>
          </Link>
        </div>
        <div>
          {user ? (
            <div className="button d-flex justify-content-between align-items-center">
              {/* <Link href="/">
                <button
                  type="button"
                  onClick={handleSignOut}
                  className={`btn mx-2 btn-outline ${styles.btnCustomOutlinePrimary}`}
                >
                  Sign out
                </button>
                  </Link> */}
              {/* Set Avatar Here */}
              <li className={`nav-item dropdown ${styles.item}`}>
                <a
                  className={`nav-link dropdown-toggle ${styles.itemDropdown}`}
                  href="#"
                  id="navbarDropdownMenuLink"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                >
                  {/* Set Name of Role or Person Name here */}
                  Customer
                </a>
                <ul className="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                  <Link href="/profile">
                    <li className={styles.logOutLink}>
                      <a className="dropdown-item" href="">
                        Profile
                      </a>
                    </li>
                  </Link>
                  <li>
                    <a className="dropdown-item" href="#">
                      Ordered History
                    </a>
                  </li>
                  <Link href="/">
                    <li className={styles.logOutLink}>
                      <a className="dropdown-item" onClick={signOut}>
                        Log out
                      </a>
                    </li>
                  </Link>
                </ul>
              </li>
            </div>
          ) : (
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
          )}
        </div>
      </div>
    </nav>
  )
}

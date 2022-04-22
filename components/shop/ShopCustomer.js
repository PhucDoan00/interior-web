import { useState, useEffect } from 'react'
import styles from '../../styles/Home.module.css'
import ProductSmall from '../productSmall'
import { getListProduct, searchProduct, searchById, searchBySelect } from '../../lib/productStyle'
import { useRouter } from 'next/router'

export default function ShopCustomer() {
  const [listProduct, setListProduct] = useState([])
  const [search, setSearch] = useState('')
  const [searchSelect, setSearchSelect] = useState('')

  useEffect(async () => {
    const data = await getListProduct()
    setListProduct(data)
  }, [])

  const handleSearch = (e) => {
    setSearch(e.target.value)
  }

  const onHandleSearch = async () => {
    // chưa dùng được phần search này
    const data = await searchProduct({ search })
    setListProduct(data)
  }

  const handleClickRedirectRoom = async (type) => {
    switch (type) {
      case 'livingroom':
        const livingroom = await searchById(5)
        setListProduct(livingroom)
        break
      case 'bedroom':
        const bedroom = await searchById(1)
        setListProduct(bedroom)
        break
      case 'diningroom':
        const diningroom = await searchById(2)
        setListProduct(diningroom)
        break
      case 'kidroom':
        const kidroom = await searchById(4)
        setListProduct(kidroom)
        break
      case 'nursery':
        const nursery = await searchById(3)
        setListProduct(nursery)
        break
      case 'all':
        const data = await getListProduct()
        setListProduct(data)
        break

      default:
        break
    }
  }

  const handleSearchSelect = (e) => {
    // chưa dùng được phần search color này
    setSearchSelect(e.target.value)
  }
  return (
    <div className={styles.mt_400}>
      <div className="container">
        <div className="row">
          <div className="col-sm-1"></div>
          <div className="col-sm-4">
            <div
              className="shop"
              style={{
                marginTop: '30px',
                marginLeft: '10px',
              }}
            >
              <h4>Shop</h4>
              <p>xxx items</p>
            </div>
          </div>
        </div>
        <div className="row">
          <div className="col-sm-1"></div>
          <div className="col-sm-10">
            <div className={styles.shop}>
              <input
                type="text"
                className={styles.input}
                value={search}
                onChange={(e) => handleSearch(e)}
              />
              <button className={`${styles.button} ${styles.btn_search}`} onClick={onHandleSearch}>
                Search
              </button>
            </div>
          </div>
          <div className="col-sm-1"></div>
        </div>
        <div className="row mt-4 d-flex justify-content-between">
          <div className="col-sm-1"></div>
          <div className="col-sm-3">
            <button className={styles.button} onClick={() => handleClickRedirectRoom('all')}>
              All
            </button>
          </div>
          <div className="col-sm-8 "> </div>
        </div>
        <div className="row mt-2 d-flex justify-content-center">
          <div className="col-sm-1"></div>
          <div className="col-sm-10 d-flex justify-content-between">
            <div className="col-sm-2">
              <button
                className={` ${styles.width}`}
                onClick={() => handleClickRedirectRoom('livingroom')}
              >
                Living Room
              </button>
            </div>
            <div className="col-sm-2">
              <button
                className={` ${styles.width}`}
                onClick={() => handleClickRedirectRoom('bedroom')}
              >
                Bed Room
              </button>
            </div>
            <div className="col-sm-2">
              <button
                className={` ${styles.width}`}
                onClick={() => handleClickRedirectRoom('diningroom')}
              >
                Dining Room
              </button>
            </div>
            <div className="col-sm-2">
              <button
                className={` ${styles.width}`}
                onClick={() => handleClickRedirectRoom('kidroom')}
              >
                Kid’s Room
              </button>
            </div>
            <div className="col-sm-2">
              <button
                className={` ${styles.width}`}
                onClick={() => handleClickRedirectRoom('nursery')}
              >
                Nursery
              </button>
            </div>
          </div>
          <div className="col-sm-1"></div>
        </div>
        <div className="row mt-4 d-flex justify-content-center">
          <div className="col-sm-1"></div>
          <div
            className="col-sm-10 d-flex"
            style={{
              marginTop: '40px',
            }}
          >
            <div>
              <select
                className={`${styles.width_selector}`}
                value={searchSelect}
                onChange={(e) => handleSearchSelect(e)}
              >
                <option selected>Color...</option>
                <option value="1">Black</option>
                <option value="2">Pink</option>
                <option value="3">Yellow/Orange</option>
                <option value="4">Blue</option>
                <option value="5">Green</option>
                <option value="6">Grey</option>
                <option value="7">White</option>
                <option value="8">Brown</option>
                <option value="9">Natural</option>
                <option value="10">Metallic</option>
              </select>
            </div>
            <div>
              <select className={`${styles.width_selector}`}>
                <option selected>Sort By...</option>
                <option value="1">One</option>
                <option value="2">Two</option>
                <option value="3">Three</option>
              </select>
            </div>
          </div>
          <div className="col-sm-1"></div>
        </div>
        <div className="row " style={{ marginTop: '100px' }}>
          <div className="col-sm-1"></div>
          <div className="col-sm-10">
            <div className="row d-flex">
              {listProduct?.map((e, index) => (
                <ProductSmall
                  key={index}
                  imgPath={e.image}
                  name={e.productName}
                  price={e.price}
                  id={e.productId}
                />
              ))}
            </div>
          </div>
          <div className="col-sm-1"></div>
        </div>
      </div>
    </div>
  )
}

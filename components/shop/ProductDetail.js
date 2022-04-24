/* eslint-disable @next/next/no-img-element */
import styles from '../../styles/Home.module.css'
import { useRouter } from 'next/router'
import { getDetailProduct } from '../../lib/productStyle'
import { NotificationContainer, NotificationManager } from 'react-notifications'
import 'react-notifications/lib/notifications.css'
import { useEffect, useState } from 'react'

const ProductDetail = () => {
  const [product, setProduct] = useState({})
  const [select, setSelect] = useState('1')
  const router = useRouter()
  const { id } = router.query

  useEffect(() => {
    async function fetchData() {
      const data = await getDetailProduct(id)
      await setProduct(data)
    }
    fetchData()
  }, [id])

  const hanleChangeSelector = (e) => {
    setSelect(e.target.value)
  }

  const handleAddCart = () => {
    let data = JSON.parse(localStorage.getItem('cart'))
    if (data?.length > 0) {
      let newData = data.filter((el) => el.product.productId !== product.productId)
      let id = data.find((el) => el.product.productId == product.productId)
      if (!id) {
        const obj = {
          select,
          product,
        }
        data.push(obj)
        localStorage.setItem('cart', JSON.stringify(data))
        NotificationManager.success('Add Success', 'You have added product to cart')
      } else {
        const quantity = Number(id.select)
        id = {
          select: quantity + Number(select),
          product,
        }
        let datas = [...newData, id]
        localStorage.removeItem('cart')
        localStorage.setItem('cart', JSON.stringify(datas))
        NotificationManager.success('Add Success', 'Product added to cart ')
      }
    } else {
      const obj = {
        select,
        product,
      }
      localStorage.setItem('cart', JSON.stringify([obj]))
      NotificationManager.success('Add Success', 'You have added product to cart')
    }
  }

  return (
    <div className={`${styles.bg_color}`}>
      <div className="container">
        <div className="row">
          <div className="col-sm-1"></div>
          <div className="col-sm-10">
            <div className="row">
              <div className="col-sm-6">
                <img src={product?.image} alt="detail img" className={styles.styleImg} />
              </div>
              <div className="col-sm-6">
                <div className={`${styles.ml_2} `}>
                  <h6 className={`${styles.fontW} ${styles.f17}`}>{product?.productName}</h6>
                  <p className={styles.f10}>In stock: {product?.quantity}</p>
                  <p className={styles.f13}>{product?.price}</p>
                  <p className={styles.f15}>Arrives in 3-7 business days from ship date</p>
                </div>
                <div className="choose pt-2 d-flex">
                  <select
                    className={`${styles.choose_select}`}
                    value={select}
                    onChange={(e) => hanleChangeSelector(e)}
                  >
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                  </select>
                  <div className="but">
                    <button
                      className={`${styles.button} ${styles.bg_nau} ${styles.width_150} ${styles.margin_0}`}
                      onClick={() => handleAddCart()}
                    >
                      Add to Cart
                    </button>
                  </div>
                </div>
                <div className={`${styles.ml_2} pt-3`}>
                  <h6 className={styles.fontW}>Dimensions</h6>
                  <p className={styles.f15}>{product?.dimension}</p>
                </div>
                <div className={`${styles.ml_2} pt-3`}>
                  <h6 className={styles.fontW}>Product details</h6>
                  <p className={styles.f15}>
                    Color: {product?.colors} <br />
                    Category :{product?.categories}
                  </p>
                </div>
                <div className={`${styles.ml_2} pt-3`}>
                  <h6 className={styles.fontW}>Overview</h6>
                  <p className={styles.f15}>{product?.description}</p>
                </div>
              </div>
            </div>
          </div>
          <div className="col-sm-1"></div>
        </div>
        <NotificationContainer />
      </div>
    </div>
  )
}

export default ProductDetail

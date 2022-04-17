import styles from '../../styles/Product.module.css'

const UpdateProduct = () => {
  return (
    <div className={`${styles.mt_400}`}>
      <div className={`container ${styles.all}`}>
        <div className="row">
          <div className={`${styles['create-title']}  mt-3`}>Update Product</div>
        </div>
        <div className="row">
          <div className="col-6 text-center ">
            <div className={`${styles.square}`}>
              <img src="../background-img.png" alt="" className={`${styles.picture}`} />
            </div>

            <a href="#" className={`${styles.button} mt-3`}>
              Change Picture
              <input type="file" name="" id="" className={`${styles.file}`} />
            </a>
          </div>
          <div className="col-6">
            <form>
              <div className="form-group">
                <label htmlFor="exampleFormControlInput1" className={`${styles.label}`}>
                  Product Name
                </label>
                <input
                  type="email"
                  className="form-control"
                  id="exampleFormControlInput1"
                  placeholder=""
                  value="California Modern Dream Home"
                />
              </div>
              <div className="form-group">
                <label htmlFor="exampleFormControlInput1" className={`${styles.label}`}>
                  Product Quantity
                </label>
                <input
                  type="email"
                  className="form-control"
                  id="exampleFormControlInput1"
                  placeholder=""
                  value="20"
                />
              </div>
              <div className="form-group">
                <label htmlFor="exampleFormControlInput1" className={`${styles.label}`}>
                  Product Price{' '}
                </label>
                <input
                  type="email"
                  className="form-control"
                  id="exampleFormControlInput1"
                  placeholder=""
                  value="1000$"
                />
              </div>
              <div className="form-group">
                <label htmlFor="exampleFormControlInput1" className={`${styles.label}`}>
                  Product Color
                </label>
                <input
                  type="email"
                  className="form-control"
                  id="exampleFormControlInput1"
                  placeholder=""
                  value="Red, Blue, Nature"
                />
              </div>
              <div className="form-group">
                <label htmlFor="exampleFormControlInput1" className={`${styles.label}`}>
                  Country of Origin{' '}
                </label>
                <input
                  type="email"
                  className="form-control"
                  id="exampleFormControlInput1"
                  placeholder=""
                  value="USA"
                />
              </div>

              <div className="form-group">
                <label htmlFor="exampleFormControlTextarea1" className={`${styles.label}`}>
                  Description
                </label>
                <textarea
                  className="form-control"
                  id="exampleFormControlTextarea1"
                  rows={3}
                  defaultValue={''}
                  value="Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor"
                />
              </div>
            </form>
            <div className={`${styles['button-group']}`}>
              <a href="#" className={`${styles.button} ${styles['button-cancel']}  mt-3`}>
                Change Picture
              </a>

              <a href="#" className={`${styles.button} ${styles['button-create']} mt-3`}>
                Change Picture
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default UpdateProduct

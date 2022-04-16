import styles from '../../styles/Home.module.css'

const ProductDetail = () => {
  return (
    <div className={`${styles.bg_color}`}>
      <div className="container">
        <div className="row">
          <div className="col-sm-1"></div>
          <div className="col-sm-10">
            <div className="row">
              <div className="col-sm-6">
                <img
                  src="/1.png"
                  alt=""
                  style={{
                    objectFit: 'cover',
                    width: '400px',
                    height: '300px',
                  }}
                />
              </div>
              <div className="col-sm-6">
                <div className={`${styles.ml_2} `}>
                  <h6 className={`${styles.fontW} ${styles.f17}`}>
                    Office Elegant Nero Noce Leather Chair
                  </h6>
                  <p className={styles.f10}>In stock: 10</p>
                  <p className={styles.f13}>12345</p>
                  <p className={styles.f15}>Arrives in 3-7 business days from ship date</p>
                </div>
                <div className="choose pt-2 d-flex">
                  <select className={`${styles.choose_select}`} value={1}>
                    <option selected>1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                  </select>
                  <div className="but">
                    <button className={`${styles.button} ${styles.bg_nau}`}>Add to Cart</button>
                  </div>
                </div>
                <div className={`${styles.ml_2} pt-3`}>
                  <h6 className={styles.fontW}>Dimensions</h6>
                  <p className={styles.f15}>38.98"H x 25.6"W x 26.97"L</p>
                </div>
                <div className={`${styles.ml_2} pt-3`}>
                  <h6 className={styles.fontW}>Product details</h6>
                  <p className={styles.f15}>
                    Color: Blue, Natural Material: 100% Handspun Cotton Care Instructions: Spot
                    Clean / Dry Clean Only Assembly Required: No Country of Origin: Viet Nam
                  </p>
                </div>
                <div className={`${styles.ml_2} pt-3`}>
                  <h6 className={styles.fontW}>Overview</h6>
                  <p className={styles.f15}>
                    Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula
                    eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient
                    montes, nascetur ridiculus mus. Donec quam felis, ultricies nec,{' '}
                  </p>
                </div>
                <div className={`${styles.ml_2} pt-3`}>
                  <h6 className={styles.fontW}>Shipping & returns</h6>
                  <p className={styles.f15}>
                    Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula
                    eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient
                    montes, nascetur ridiculus mus. Donec quam felis, ultricies nec,{' '}
                  </p>
                </div>
              </div>
            </div>
          </div>
          <div className="col-sm-1"></div>
        </div>
      </div>
    </div>
  )
}

export default ProductDetail

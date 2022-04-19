import Layout from '../components/layout';
import ProductCart from '../components/shop/ProductCart';
import withAuth from '../components/withAuth';

const Cart = () => {
  return (
    <Layout>
      <ProductCart />
    </Layout>
  )
}

export default withAuth(Cart)

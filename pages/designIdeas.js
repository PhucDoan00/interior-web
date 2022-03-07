import Layout from '../components/layout'
import Topbar from '../components/topbar'
import Footer from '../components/footer'

export default function DesignIdeas() {
  return <div className=""></div>
}

DesignIdeas.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      {page}
      <Footer />
    </Layout>
  )
}

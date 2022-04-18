import { useRouter } from 'next/router'

const Success = () =>{
    const router = useRouter()

    const handleRedirect = ()=>{
        router.push('/shop')
    }
return (
    <div class="container">
        <div class="row" style={{
            display: 'flex',
            flexDirection: 'column',
            justifyContent: 'center',
            alignItems: 'center'
        }}>
            <div class="center" style={{
                width:'10%',
                margin:'50px auto'
            }}>
                <img src="/success.png" alt="" style={{height:'100px' , width:'100px',fontSize:'100px'}}/>
            </div>
            <div style={{ textAlign :'center'}}>
                <h1 className="" style={{
                    fontSize:'15px'
                }}>Purchase Successfull</h1>
                <button style={{
                    outline:'none',
                    border:'1px solid green',
                    backgroundColor:'green',
                    color:'white',
                    padding:'5px 10px',
                    marginTop:'20px',
                    borderRadius:'5px'
                }}
                onClick={handleRedirect}
                >Back To Shop !</button>
            </div>
        </div>
    </div>
)
}
export default Success
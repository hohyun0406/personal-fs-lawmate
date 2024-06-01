import instance from "../../common/configs/axios-config"

export const findAllBoardAPI = async (page : number) => { //보드리스트용
    try{
        const response = await instance().get('/board/list', {
            params : {page, limit :10}
        })
        return response.data
    } catch (error){
        console.log('api communicate error - axios')
        return error
    }
}

export const findBoardByIdAPI = async (id : number) => {
    console.log('감지된 페이지 번호 : ' + id)
    try{
        const response = await instance().get(`/board/search`,{
            params: {q : id}
        })
        return response.data
        
    }catch(error){
        console.log(error)
        return error
    }
}
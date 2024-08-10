import  instance  from "@/app/components/common/configs/axios-config"
import { IUser } from "../model/user"



export const joinAPI = async (user:IUser) => {
    console.log(`회원가입API에 넘어온 파라미터 : ${JSON.stringify(user)}`)
    try {const response = await instance().post('/auth/join', user)
        return response.data.message
    } catch (error) {
        console.log("답 없음")
        return error
    }
}

export const loginAPI = async (user:IUser) => {
    console.log(`로그인API에 넘어온 파라미터 : ${JSON.stringify(user)}`)
    try {const response = await instance().post('/auth/login', user)
        return response.data
    } catch (error) {
        console.log("답 없음")
        return error
    }
}
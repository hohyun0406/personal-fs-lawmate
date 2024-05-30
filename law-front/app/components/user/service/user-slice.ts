import { createSlice } from "@reduxjs/toolkit"
import { saveNewUser } from "./user-service"
import { IUser } from "../model/user"


const status = {
    pending : 'pending',
    fulfilled : 'fulfilled',
    rejected : 'rejected'
}
interface IAuth{
    message? : string
    token? : string
}
interface UserState  {
    json? : IUser,
    array? : Array<IUser>,
    auth?: IAuth,
    msg? : string
}
export const initialState:UserState = {
    json : {} as IUser,
    array : [],
    auth : {} as IAuth,
    msg : ''
}

export const userSlice = createSlice({
    name : "users",
    initialState,
    reducers: {},
    extraReducers : builder => {
        const {pending, rejected} = status;

        builder
        .addCase(saveNewUser.fulfilled, (state : any, {payload}:any)=>{state.auth = payload})
    }
})

export const getNewUser = (state : any) => {return state.user.auth}

export const {} = userSlice.actions

export default userSlice.reducer
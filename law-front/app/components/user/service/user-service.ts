import { createAsyncThunk } from "@reduxjs/toolkit";
import { joinAPI, loginAPI } from "./user-api";
import { IUser } from "../model/user";

export const saveNewUser : any = createAsyncThunk(
    'users/join',
    async (user:IUser) => await joinAPI(user)
)

export const loginUser : any = createAsyncThunk(
    'users/login',
    async (user:IUser) => await loginAPI(user)
)
import { createAsyncThunk } from "@reduxjs/toolkit";
import { findAllBoardAPI, findBoardByIdAPI } from "./board-api";

export const findAllBoards: any = createAsyncThunk(
    "boards/list",
    async (page: number) => {
      console.log("findAllboards page : " + page);
      const data : any = await findAllBoardAPI(page);
      const {message, result}:any = data
      return data
    }
  )

export const findBoardById: any = createAsyncThunk(
  "boards/법령명한글",
  async (id : number) => {
    console.log("finding boards.. ")
    const data : any = await findBoardByIdAPI(id);
    return data
  }
)
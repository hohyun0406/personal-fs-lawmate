import { createAsyncThunk } from "@reduxjs/toolkit";
import { sendMessageAPI } from "./chat-api";

export const sendMessage = createAsyncThunk(
    'chat/sendMessage',
    async (message: any) => await sendMessageAPI(message)
);
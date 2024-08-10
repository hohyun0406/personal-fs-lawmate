// chat-slice.ts
import { createSlice } from "@reduxjs/toolkit";
import { sendMessage } from "./chat-service";

interface ChatState {
    messages: Array<string>;
    error?: string;
}

const initialState: ChatState = {
    messages: [],
    error: undefined,
};

const chatSlice = createSlice({
    name: "chat",
    initialState,
    reducers: {},
    extraReducers: (builder) => {
        builder
            .addCase(sendMessage.fulfilled, (state, action) => {
                state.messages.push(action.payload.message); // 서버에서 응답한 메시지를 추가
            })
            .addCase(sendMessage.rejected, (state, action) => {
                state.error = action.error.message; // 에러 메시지 저장
            });
    },
});

export const getChatMessages = (state: any) => state.chat.messages;

export default chatSlice.reducer;

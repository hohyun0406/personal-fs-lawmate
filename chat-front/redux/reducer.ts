import { combineReducers } from "@reduxjs/toolkit";
import { persistReducer } from "redux-persist";
import userReducer from "@/app/components/user/service/user-slice";
import chatReducer from "@/app/components/chat/service/chat-slice"; // 추가된 슬라이스
import createWebStorage from "redux-persist/lib/storage/createWebStorage";


const createNoopStorage = () => {
  return {
    getItem() {
      return Promise.resolve(null);
    },
    setItem(_key: string, value: number) {
      return Promise.resolve(value);
    },
    removeItem() {
      return Promise.resolve();
    },
  };
};

const storage =
  typeof window !== "undefined"
    ? createWebStorage("local")
    : createNoopStorage();

const userPersistConfig = {
  key : "user",
  storage,
  whitelist : ["userState"],
}

const chatPersistConfig = {
  key : "chat",
  storage,
  whitelist : ["chatState"],
}

const persistedUserReducer = persistReducer(userPersistConfig, userReducer);
const persistedChatReducer = persistReducer(chatPersistConfig, chatReducer);

export const rootReducer = combineReducers({
  user : persistedUserReducer,
  chat : persistedChatReducer
});
import  instance  from "@/app/components/common/configs/axios-config"


export const sendMessageAPI = async (message: any) => {
  console.log(`챗봇 API에 전송된 메시지: ${message}`);
  try {
      const response = await instance().post('/chat/send', { message });
      return response.data; // 필요에 따라 데이터 형식을 조정
  } catch (error) {
      console.log("API 호출 오류:", error);
      throw error; // 에러를 던져서 Redux에서 처리하도록 합니다.
  }
};
import requests
import xml.etree.ElementTree as ET
import csv
import pandas as pd

# CSV 파일에서 판례일련번호를 읽어오기
input_csv_file = 'civil_prec_list.csv'
ids_df = pd.read_csv(input_csv_file)

# 요청할 ID 목록
ids = ids_df['판례일련번호'].tolist()

# XML 데이터를 가져올 URL 템플릿
url_template = "https://www.law.go.kr/DRF/lawService.do?OC=hh7769&target=prec&type=XML&ID={}"

# CSV 파일을 작성할 필드명
fields = [
    "판례정보일련번호", "사건명", "사건번호", "선고일자", "선고", "법원명", 
    "법원종류코드", "사건종류명", "사건종류코드", "판결유형", "판시사항", 
    "판결요지", "참조조문", "참조판례", "판례내용"
]

# CSV 파일 작성
output_csv_file = 'civil_prec_detail.csv'
with open(output_csv_file, 'w', newline='', encoding='utf-8') as csvfile:
    csvwriter = csv.writer(csvfile)
    
    # 헤더 작성
    csvwriter.writerow(fields)
    
    # 각 ID에 대해 데이터를 요청하고 CSV에 작성
    for case_id in ids:
        # 현재 진행 상황 출력
        print(f"현재 가져오는 판례일련번호: {case_id}")
        
        # 각 ID에 대해 URL을 생성
        url = url_template.format(case_id)
        
        # XML 데이터 요청
        response = requests.get(url)
        response.encoding = 'utf-8'  # 인코딩 설정
        
        # 응답이 성공적인지 확인
        if response.status_code != 200:
            print(f"Error: Failed to retrieve data for case ID {case_id}")
            continue
        
        # XML 파싱
        root = ET.fromstring(response.content)
        
        # 데이터 작성
        data = []
        for field in fields:
            element = root.find(field)
            if element is not None and element.text is not None:
                # CDATA 처리
                data.append(element.text.strip())
            else:
                data.append("")
        
        # CSV 파일에 행 추가
        csvwriter.writerow(data)

print("CSV 파일 작성 완료: civil_prec_detail.csv")

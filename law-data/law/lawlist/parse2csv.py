import requests
import xml.etree.ElementTree as ET
import csv

# Open API URL 템플릿
url_template = "https://www.law.go.kr/DRF/lawSearch.do?OC=hh7769&target=law&type=XML&display=100&page={}"

# CSV 파일 생성
csv_file = open('law_list.csv', 'w', newline='', encoding='utf-8')
csv_writer = csv.writer(csv_file)

# CSV 파일의 헤더 작성
header = ["법령일련번호", "현행연혁코드", "법령명한글", "법령약칭명", "법령ID", "공포일자", "공포번호", "제개정구분명", "소관부처코드", "소관부처명", "법령구분명", "시행일자", "법령상세링크"]
csv_writer.writerow(header)

# 페이지 번호를 증가시키며 데이터 가져오기
page = 1
while True:
    # URL에 페이지 번호를 삽입
    url = url_template.format(page)
    response = requests.get(url)
    
    # 응답이 성공적인지 확인
    if response.status_code != 200:
        print(f"Error: Failed to retrieve data for page {page}")
        break
    
    xml_data = response.content
    root = ET.fromstring(xml_data)
    
    # numOfRows 값을 확인하여 데이터가 없는지 체크
    num_of_rows = int(root.find('numOfRows').text)
    if num_of_rows == 0:
        print(f"Page {page}에 데이터가 없습니다. 루프를 종료합니다.")
        break
    
    # 법령 데이터를 CSV 파일에 작성
    for law in root.findall('law'):
        row = []
        for tag in header:
            element = law.find(tag)
            if element is not None and element.text is not None:
                row.append(element.text.strip())
            else:
                row.append("")
        csv_writer.writerow(row)
    
    print(f"Page {page} 데이터가 추가되었습니다.")
    
    # 페이지 번호 증가
    page += 1

# CSV 파일 닫기
csv_file.close()

print("모든 페이지의 CSV 데이터가 law_list.csv 파일에 저장되었습니다.")

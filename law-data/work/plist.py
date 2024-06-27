import requests
import xml.etree.ElementTree as ET
import csv

# Open API URL 템플릿
url_template = "https://www.law.go.kr/DRF/lawSearch.do?OC=hh7769&target=prec&type=XML&display=100&JO=형사소송법&page={}"

# CSV 파일 생성
csv_file = open('criminal_procedure_prec_list.csv', 'w', newline='', encoding='utf-8')
csv_writer = csv.writer(csv_file)

# CSV 파일의 헤더 작성
header = ["판례일련번호", "사건명", "사건번호", "선고일자", "법원명", "법원종류코드", "사건종류명", "사건종류코드", "판결유형", "선고", "판례상세링크"]
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
    
    # 'prec' 요소가 있는지 확인하여 데이터가 없는지 체크
    prec_elements = root.findall('prec')
    if not prec_elements:
        print(f"Page {page}에 데이터가 없습니다. 루프를 종료합니다.")
        break
    
    # 법령 데이터를 CSV 파일에 작성
    for law in prec_elements:
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

print("모든 페이지의 CSV 데이터가 criminal_procedure_prec_list.csv 파일에 저장되었습니다.")
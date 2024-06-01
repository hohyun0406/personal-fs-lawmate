import requests
import xml.etree.ElementTree as ET
import json

# Open API URL 템플릿
url_template = "https://www.law.go.kr/DRF/lawSearch.do?OC=hh7769&target=law&type=XML&page={}"

# 모든 페이지의 데이터를 저장할 리스트
all_data = []

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
    
    # XML을 JSON 형태로 변환
    def xml_to_dict(element):
        result = {}
        if element.attrib:
            result.update(element.attrib)
        for child in element:
            child_result = xml_to_dict(child)
            tag = child.tag
            if tag not in result:
                result[tag] = child_result
            else:
                if not isinstance(result[tag], list):
                    result[tag] = [result[tag]]
                result[tag].append(child_result)
        if element.text and element.text.strip():
            text = element.text.strip()
            if result:
                result['text'] = text
            else:
                result = text
        return result
    
    page_data = xml_to_dict(root)
    
    # 데이터를 리스트에 추가
    all_data.append(page_data)
    
    print(f"Page {page} 데이터가 추가되었습니다.")
    
    # 페이지 번호 증가
    page += 1

# 모든 페이지의 데이터를 JSON 파일로 저장
with open('law_data2.json', 'w', encoding='utf-8') as json_file:
    json.dump(all_data, json_file, ensure_ascii=False, indent=4)

print("모든 페이지의 JSON 데이터가 law_data.json 파일에 저장되었습니다.")

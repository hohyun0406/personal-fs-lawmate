import pandas as pd
import numpy as np  # NaN 값을 처리하기 위해 추가
import mysql.connector

# CSV 파일 읽기
csv_file_path = 'law_data.csv'
data = pd.read_csv(csv_file_path, encoding='utf-8')

# 결측치 처리 (NaN 값을 0으로 대체)
data['소관부처코드'] = data['소관부처코드'].fillna('0').astype(str)  # 결측치를 문자열 '0'으로 대체하고, 문자열로 변환

# MySQL 데이터베이스에 연결
connection = mysql.connector.connect(
    host='localhost',
    port=3306,
    user='root',
    password='root',
    database='lawdb'
)

# 연결 확인
if connection.is_connected():
    print("데이터베이스에 성공적으로 연결되었습니다.")

    # 컬럼 이름 확인
    print("데이터프레임의 컬럼 이름:", data.columns)

    # 테이블 생성 (필요시)
    create_table_query = '''
    CREATE TABLE IF NOT EXISTS law_data (
        법령일련번호 INT,
        현행연혁코드 VARCHAR(255),
        법령명한글 VARCHAR(255),
        법령약칭명 VARCHAR(255),
        법령ID INT,
        공포일자 INT,
        공포번호 VARCHAR(255),
        제개정구분명 VARCHAR(255),
        소관부처코드 VARCHAR(255),  # 문자열로 변경
        소관부처명 VARCHAR(255),
        법령구분명 VARCHAR(255),
        시행일자 INT,
        법령상세링크 TEXT
    )
    '''
    mycursor = connection.cursor()
    mycursor.execute(create_table_query)
    
    # 데이터 삽입
    insert_query = '''
    INSERT INTO law_data (법령일련번호, 현행연혁코드, 법령명한글, 법령약칭명, 법령ID, 공포일자, 공포번호, 제개정구분명, 소관부처코드, 소관부처명, 법령구분명, 시행일자, 법령상세링크)
    VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
    '''
    
    for i, row in data.iterrows():
        val = (
            int(row['법령일련번호']), str(row['현행연혁코드']), str(row['법령명한글']), str(row['법령약칭명']),
            int(row['법령ID']), int(row['공포일자']), str(row['공포번호']), str(row['제개정구분명']), 
            str(row['소관부처코드']), str(row['소관부처명']), str(row['법령구분명']), int(row['시행일자']), 
            str(row['법령상세링크'])
        )
        mycursor.execute(insert_query, val)
    
    connection.commit()
    print("CSV 데이터가 데이터베이스에 성공적으로 저장되었습니다.")
    mycursor.close()
    connection.close()
else:
    print("데이터베이스에 연결할 수 없습니다.")

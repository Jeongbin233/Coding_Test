-- 코드를 입력하세요
SELECT b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, date_format(r.created_date, "%Y-%m-%d") as CREATED_DATE
from used_goods_board as b, used_goods_reply as r 
where b.board_id = r.board_id and date_format(b.created_date, "%Y-%m")="2022-10" 
order by r.created_date, b.title;
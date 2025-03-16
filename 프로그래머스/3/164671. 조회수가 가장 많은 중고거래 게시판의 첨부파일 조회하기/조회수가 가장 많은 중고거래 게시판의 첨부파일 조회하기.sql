-- 코드를 입력하세요
# SELECT concat('/home/grep/src/',b.board_id,'/', FILE_ID,	FILE_NAME, FILE_EXT) FILE_PATH from
# USED_GOODS_BOARD b join USED_GOODS_FILE f on b.BOARD_ID = f.BOARD_ID
# group by b.BOARD_ID, FILE_ID,	FILE_EXT,	FILE_NAME
# order by file_id desc

SELECT concat('/home/grep/src/',b.board_id,'/', FILE_ID,	FILE_NAME, FILE_EXT) FILE_PATH from
USED_GOODS_BOARD b join USED_GOODS_FILE f on b.BOARD_ID = f.BOARD_ID
where views =
(select Max(views) from USED_GOODS_BOARD)order by file_id desc
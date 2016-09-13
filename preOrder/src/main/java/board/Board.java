package board;

import java.util.Date;

public class Board {
	private int num;
	private int hostId; 
	private int writerId;
	private String pw;
	private String subject;
	private String content;
	private String file;
	private int reRef;
	private int reLev;
	private int reSeq;
	private int readCount;
	private Date datetime;
	
	public Board(int num, int hostId, int writerId, String pw, String subject, String content, String file, int reRef,
			int reLev, int reSeq, int readCount, Date datetime) {
		super();
		this.num = num;
		this.hostId = hostId;
		this.writerId = writerId;
		this.pw = pw;
		this.subject = subject;
		this.content = content;
		this.file = file;
		this.reRef = reRef;
		this.reLev = reLev;
		this.reSeq = reSeq;
		this.readCount = readCount;
		this.datetime = datetime;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getHostId() {
		return hostId;
	}
	public void setHostId(int hostId) {
		this.hostId = hostId;
	}
	public int getWriterId() {
		return writerId;
	}
	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public int getReRef() {
		return reRef;
	}
	public void setReRef(int reRef) {
		this.reRef = reRef;
	}
	public int getReLev() {
		return reLev;
	}
	public void setReLev(int reLev) {
		this.reLev = reLev;
	}
	public int getReSeq() {
		return reSeq;
	}
	public void setReSeq(int reSeq) {
		this.reSeq = reSeq;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
}

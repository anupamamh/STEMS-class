package com.rsrit.coursemngt.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rsrit.coursemngt.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
		
	@Query("Select a from Attendance as a, Session as s where s.sessionId=a.session and s.sessionId=:sessId and a.studentsIds=:studId")
	public Attendance findDuplicateAttendance(@Param("sessId") Long sessId,@Param("studId") Long studId);

	/*
	 * my query Select A.ATTENDANCE_ID, A.PRESENT, A.SESSION_SESSION_ID,
	 * A.STUDENTS_IDS from ATTENDANCE AS A INNER JOIN SESSION AS S ON
	 * A.SESSION_SESSION_ID =S.SESSION_ID AND SESSION_SESSION_ID =3 AND
	 * A.STUDENTS_IDS =3;
	 */
}

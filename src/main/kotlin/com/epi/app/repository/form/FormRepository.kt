package com.epi.app.repository.form

import com.epi.app.entity.form.Form
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface FormRepository : JpaRepository<Form, Long> {

    @Query("SELECT COUNT(0) FROM tb_forms WHERE MONTH(date_register) = MONTH(CURRENT_DATE) AND YEAR(date_register) = YEAR(CURRENT_DATE)", nativeQuery = true)
    fun countForms(): Int

    @Query(
        """
    SELECT COUNT(f)
    FROM Form f
    WHERE f.useMandatory = 'SIM'
      AND (
            f.useAdequate = 'NAO'
         OR f.state IN ('BAD', 'TERRIBLE')
         OR f.adequatePlace = 'NAO'
      )
      AND MONTH(f.dateRegister) = MONTH(CURRENT_DATE)
      AND YEAR(f.dateRegister) = YEAR(CURRENT_DATE)
    """
    )
    fun countFormsWithNoUseAdequate(): Int

}
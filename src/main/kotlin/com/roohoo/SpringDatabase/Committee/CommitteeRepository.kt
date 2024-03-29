package com.roohoo.SpringDatabase.Committee

import org.springframework.data.repository.CrudRepository

interface CommitteeRepository : CrudRepository<CommitteeMember, Int> {
    fun findByCommitteeEntryId(id: Int): CommitteeMember
    fun findByCommitteeName(name: String): List<CommitteeMember>
    fun findByUserId(id: Int): List<CommitteeMember>
}
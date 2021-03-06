package kr.h4lo.study.model

import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "accounts")
data class Account (@Id
                    @GeneratedValue(strategy = GenerationType.AUTO)
                    var id: Int? = null,
                    @Column(nullable = false, unique = true, name = "user_id")
                    @Size(min = 3, max = 255)
                    var userId : String?,
                    @Size(min = 8)
                    @Column(nullable = false)
                    var password: String?,
                    @Column(nullable = false)
                    var nickname: String?,
                    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
                    @JoinColumn(name = "user_id")
                    var roles: List<Role>?)